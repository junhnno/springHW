package com.likelion.springhw.guestbook.controller;

import com.likelion.springhw.guestbook.dto.GuestDetailResponse;
import com.likelion.springhw.guestbook.dto.GuestbookSummaryResponse;
import com.likelion.springhw.guestbook.dto.GuestbookUpdateRequest;
import com.likelion.springhw.guestbook.service.GuestbookService;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.likelion.springhw.guestbook.dto.GuestbookCreateRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/guestbooks")
public class GuestbookController {

    private final GuestbookService guestbookService;

    public GuestbookController(GuestbookService guestbookService) {
        this.guestbookService = guestbookService;
    }

    @GetMapping
    public List<GuestbookSummaryResponse> getGuestbooks() {
        return guestbookService.getGuestbookSummaries();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuestDetailResponse createGuestbook(
            @Valid @RequestBody GuestbookCreateRequest request
    ) {
        return guestbookService.createGuestbook(request);
    }

    @GetMapping("/{guestbookId}")
    public GuestDetailResponse getGuestbook(
            @PathVariable("guestbookId") Long guestbookId
    ) {
        return guestbookService.getGuestbookDetail(guestbookId);
    }

    @PutMapping("/{guestbookId}")
    public GuestDetailResponse updateGuestbook(
            @PathVariable("guestbookId") Long guestbookId,
            @Valid @RequestBody GuestbookUpdateRequest request

    ) {
        return guestbookService.updateGuestbook(guestbookId, request);
    }

    @DeleteMapping("/{guestbookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuestbook(@PathVariable("guestbookId") Long guestbookId) {
        guestbookService.deleteGuestbook(guestbookId);
    }
}
