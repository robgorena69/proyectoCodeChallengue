package com.dh.CodeChallengue.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.dh.CodeChallengue.dominio.Actividad;
import com.dh.CodeChallengue.dominio.Empleado;

public class ActividadRepository {

    public Actividad findActividad(int id) {
        Actividad actividad = new Actividad();
        return actividad;
    }

    public int registraActividad(Actividad actividad) {
        return 1000; // se mockea un id generado a raiz del registro de la actividad
    }

    public List<Actividad> lstActividadByEmpleado(Empleado empleado) {
        List<Actividad> lstActividad = new ArrayList<>();
        // Se mockea varias actividades como respuesta Se deberia hacer una consulta con
        // los empleados asociads a la actividad
        Actividad act1 = new Actividad();
        act1.setDescripcion("actividad 1");
        act1.setFechaInicio(LocalDateTime.now());
        act1.setEmpleado(empleado);
        lstActividad.add(act1);
        Actividad act2 = new Actividad();
        act2.setDescripcion("actividad 2");
        act2.setFechaInicio(LocalDateTime.now());
        act2.setEmpleado(empleado);
        lstActividad.add(act2);
        return lstActividad;
    }
}
