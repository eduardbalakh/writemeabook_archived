package com.example.application.dao.subsection;

import com.example.application.model.Subsection;

import java.util.List;

public interface SubsectionDAO {
    List<Subsection> getAllSubsections();

    void saveSubsection(Subsection subsection);

    Subsection getSubsection(int id);

    void deleteSubsection(int id);
}
