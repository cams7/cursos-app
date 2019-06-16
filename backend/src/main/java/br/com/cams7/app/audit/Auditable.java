/**
 * 
 */
package br.com.cams7.app.audit;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.cams7.app.View;
import br.com.cams7.app.model.UsuarioEntity;

/**
 * @author ceanm
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements Serializable {

	@JsonView(View.Public.class)
	@CreatedBy
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "criado_por")
	private UsuarioEntity createdBy;

	@JsonView(View.Public.class)
	@CreatedDate
	@Column(name = "data_criacao")
	private LocalDateTime createdDate;

	@JsonView(View.Public.class)
	@LastModifiedBy
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modificado_por")
	private UsuarioEntity lastModifiedBy;

	@JsonView(View.Public.class)
	@LastModifiedDate
	@Column(name = "data_alteracao")
	private LocalDateTime lastModifiedDate;

	public UsuarioEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UsuarioEntity createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public UsuarioEntity getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(UsuarioEntity lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
