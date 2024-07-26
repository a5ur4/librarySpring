package com.a5ur4.library.dtos;

public record BookDTO(Integer id, String title, String author, String genre, String description, Boolean isUsing, Long bookOwnerId) {}
