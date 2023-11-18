package com.dh.CodeChallengue.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.dh.CodeChallengue.dominio.Pto;

public class PtoRepository {

    public int crearPto(Pto pto) {
        return 1500; // se moquea un numero que debia ser el registro
    }

    public Pto findPtoById(Long id) {
        Pto pto = new Pto();
        pto.setEstado("AC");
        pto.setFechaInicio(LocalDateTime.now());
        return pto; // se moquea un PTO
    }

    public List<Pto> listarPto() {
        ArrayList<Pto> lstPTO = new ArrayList<>();
        Pto pto1 = new Pto();
        pto1.setFechaInicio(LocalDateTime.now());
        pto1.setEstado("AC");
        lstPTO.add(pto1);
        Pto pto2 = new Pto();
        pto2.setFechaInicio(LocalDateTime.now());
        pto2.setEstado("AC");
        lstPTO.add(pto2);
        return lstPTO;
    }

    public void actualizaPto(Pto pto) {
        // se mockea la persistencia del PTO
    }
}
