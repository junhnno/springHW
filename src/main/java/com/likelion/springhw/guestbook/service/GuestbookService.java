package com.likelion.springhw.guestbook.service;

import com.likelion.springhw.guestbook.dto.GuestDetailResponse;
import com.likelion.springhw.guestbook.dto.GuestbookCreateRequest;
import com.likelion.springhw.guestbook.dto.GuestbookSummaryResponse;
import com.likelion.springhw.guestbook.dto.GuestbookUpdateRequest;
import com.likelion.springhw.guestbook.entity.Guestbook;
import com.likelion.springhw.guestbook.repository.GuestbookRepository;
import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestbookService {

    private final GuestbookRepository guestbookRepository;

    public List<GuestbookSummaryResponse> getGuestbookSummaries() {
        List<Guestbook> guestbooks = guestbookRepository.findAll();
        List<GuestbookSummaryResponse> responses = new ArrayList<>();

        for (Guestbook guestbook : guestbooks) {
            GuestbookSummaryResponse response = new GuestbookSummaryResponse(
                    guestbook.getId(),
                    guestbook.getTitle(),
                    guestbook.getWriter(),
                    guestbook.getPs()
            );

            responses.add(response);
        }

        return responses;
    }

    public GuestDetailResponse getGuestbookDetail(Long guestbookId) {
        Guestbook guestbook = findGuestbookById(guestbookId);
        return toDetailResponse(guestbook);
    }

    public GuestDetailResponse createGuestbook(GuestbookCreateRequest request) {
        Guestbook guestbook = new Guestbook(
                request.getTitle(),
                request.getContent(),
                request.getWriter(),
                request.getPs()
        );

        Guestbook savedGuestbook = guestbookRepository.save(guestbook);

        return toDetailResponse(savedGuestbook);
    }

    private Guestbook findGuestbookById(Long guestbookId) {
        return guestbookRepository.findById(guestbookId)
                .orElseThrow();
    }

    private GuestDetailResponse toDetailResponse(Guestbook guestbook) {
        return new GuestDetailResponse(
                guestbook.getId(),
                guestbook.getTitle(),
                guestbook.getContent(),
                guestbook.getWriter(),
                guestbook.getCreatedAt(),
                guestbook.getPs()
        );
    }

    @Transactional
    public GuestDetailResponse updateGuestbook(
            Long guestbookId,
            GuestbookUpdateRequest request
    ) {
        Guestbook guestbook = findGuestbookById(guestbookId);

        guestbook.update(
                request.getTitle(),
                request.getContent(),
                request.getPs()
        );
        return toDetailResponse(guestbook);
    }

    @Transactional
    public void deleteGuestbook(Long guestbookId) {
        Guestbook guestbook = findGuestbookById(guestbookId);

        guestbookRepository.delete(guestbook);
    }
}
