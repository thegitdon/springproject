package co.com.toject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pcomment")
public class PComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//@Column(columnDefinition = "TEXT")
	@Lob
	private String content;
	@ManyToOne(fetch = FetchType.LAZY, optional = false) // optional element is set to false for non-null relationship;
															// EAGER but it is bad for performance
	@JoinColumn(name = "ptest_id", nullable = false) // specify the foreign key column
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore // used to ignore the logical property used in serialization and deserialization
	private PTest tutorial;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PTest getTutorial() {
		return tutorial;
	}

	public void setTutorial(PTest tutorial) {
		this.tutorial = tutorial;
	}

}
