package com.microservicios.app.cursos.services;


import org.springframework.web.bind.annotation.PathVariable;


import com.microservicios.app.cursos.models.entity.Curso;
import com.microservicios.commons.alumnos.models.entity.Alumno;
import com.microservicios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso>{
	
	public Curso findCursoByAlumnoId(Long id);
	
	public Iterable<Long> obtenerExamenesIdsRespondidosAlumnos(@PathVariable Long alumnoId);
	
	public Iterable<Alumno>obtenerAlumnosPorCurso(Iterable<Long> ids);
	
	public void eliminarCursoAlumnoPorId(Long id);
	
}
