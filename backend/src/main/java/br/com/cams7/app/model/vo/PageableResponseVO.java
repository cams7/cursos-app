/**
 * 
 */
package br.com.cams7.app.model.vo;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Getter;

/**
 * @author cams7
 *
 */
@Getter
@SuppressWarnings("serial")
public class PageableResponseVO<T> extends PageImpl<T> {

	private boolean last;
	private boolean first;
	private int totalPages;
	private int numberOfElements;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public PageableResponseVO(@JsonProperty("content") List<T> content, @JsonProperty("number") int page,
			@JsonProperty("size") int size, @JsonProperty("totalElements") long totalElements,
			@JsonProperty("pageable") JsonNode pageable, @JsonProperty("totalPages") int totalPages,
			@JsonProperty("last") boolean last, @JsonProperty("first") boolean first,
			@JsonProperty("sort") JsonNode sort, @JsonProperty("numberOfElements") int numberOfElements) {

		super(content, PageRequest.of(page, size), totalElements);

		this.totalPages = totalPages;
		this.last = last;
		this.first = first;
		this.numberOfElements = numberOfElements;
	}

}
