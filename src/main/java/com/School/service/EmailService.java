package com.School.service;

import com.School.dto.request.EmailDto;

public interface EmailService {
    void sendEmail(EmailDto emailDto);
}
