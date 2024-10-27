package com.hussi.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.print.Book;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

public interface IController {

    @GetMapping("/get-period/{}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Healthcheck successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input supplied",
                    content = @Content)})
    CompletableFuture<ResponseEntity<String>> getBillingPeriodByDate(Date date);

    @GetMapping("/healthcheck")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Healthcheck successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input supplied",
                    content = @Content)})
    CompletableFuture<ResponseEntity<String>> getBillingListByYear(int year);
}
