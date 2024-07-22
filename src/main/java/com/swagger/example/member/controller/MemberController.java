package com.swagger.example.member.controller;

import com.swagger.example.member.dto.AddMemberDto;
import com.swagger.example.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Member-API", description = "회원 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService service;

    @Operation(summary = "게시글 작성")
    @PostMapping
    public ResponseEntity<AddMemberDto.Response> addMember(@RequestBody AddMemberDto.Request request) {
        log.info("Member Controller addMember init");
        AddMemberDto.Response response = service.addMember(request);
        return ResponseEntity.created(null).body(response);
    }
}
