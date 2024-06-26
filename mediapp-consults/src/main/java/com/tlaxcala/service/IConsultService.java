package com.tlaxcala.service;

import java.time.LocalDateTime;
import java.util.List;

import com.tlaxcala.dto.ConsultDTO;
import com.tlaxcala.dto.ConsultProcDTO;
import com.tlaxcala.dto.IConsultProcDTO;
import com.tlaxcala.model.Consult;
import com.tlaxcala.model.Exam;
import com.tlaxcala.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IConsultService extends ICRUD<Consult, Integer> {

    Consult saveTransactional(Consult consult, List<Exam> exams);
    List<Consult> search(String dni, String fullname);
    List<Consult> searchByDates(LocalDateTime date1, LocalDateTime date2);
    List<ConsultProcDTO> callProcedureOrFunctionNative();
    List<IConsultProcDTO> callProcedureOrFunctionProjection();
    byte[] generateReport() throws Exception;

    Page<Consult> listPage(Long patient, Pageable pageable);

}
