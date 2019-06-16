/**
 * 
 */
package br.com.cams7.app.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.cams7.app.model.AlunoEntity;
import br.com.cams7.app.model.CursoEntity;

/**
 * @author ceanm
 *
 */
@Repository
public class AlunoRepositoryImpl implements AlunoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<AlunoEntity> findAlunosByNomeAndCurso(String alunoNome, String cursoNome) {

		alunoNome = alunoNome.trim();
		cursoNome = cursoNome.trim();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AlunoEntity> cq = cb.createQuery(AlunoEntity.class);

		Root<AlunoEntity> aluno = cq.from(AlunoEntity.class);
		Join<AlunoEntity, CursoEntity> cursos = aluno.join("cursos");

		List<Predicate> predicates = new ArrayList<>();

		if (!alunoNome.isEmpty())
			predicates.add(cb.like(cb.lower(aluno.get("nome")), "%" + alunoNome.trim().toLowerCase() + "%"));
		if (!cursoNome.isEmpty())
			predicates.add(cb.like(cb.lower(cursos.get("nome")), "%" + cursoNome.trim().toLowerCase() + "%"));
		cq.where(predicates.stream().toArray(Predicate[]::new));

		EntityGraph<?> entityGraph = em.getEntityGraph(AlunoEntity.SHOW_CURSOS);

		TypedQuery<AlunoEntity> query = em.createQuery(cq).setHint("javax.persistence.loadgraph", entityGraph);
		return query.getResultList();
	}
}
