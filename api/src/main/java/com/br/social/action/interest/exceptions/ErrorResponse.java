package com.br.social.action.interest.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(Integer statusCode, LocalDateTime timestamp, String id, String message) {}
