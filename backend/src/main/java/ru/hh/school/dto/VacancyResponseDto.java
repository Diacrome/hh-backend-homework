package ru.hh.school.dto;


import ru.hh.school.entity.CompanyEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class VacancyResponseDto {
    private Long vacancyId;
    private String title;
    private LocalDate creationDate;
    private CompanyEntity company;

    public VacancyResponseDto(Long vacancyId, String title, LocalDate creationDate, CompanyEntity company) {
        this.vacancyId = vacancyId;
        this.title = title;
        this.creationDate = creationDate;
        this.company = company;
    }

    public Long getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(Long vacancyId) {
        this.vacancyId = vacancyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
}
