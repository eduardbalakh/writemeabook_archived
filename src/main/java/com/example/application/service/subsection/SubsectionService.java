package com.example.application.service.subsection;

import com.example.application.model.Subsection;

import java.util.List;

public interface SubsectionService {

    List<Subsection> getAllSubsections();

    void saveSubsection(Subsection subsection);

    Subsection getSubsection(int id);

    void deleteSubsection(int id);
}
