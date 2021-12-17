package com.hatcher.sping_data_jdbc_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/12
 * @Description:
 */
@Table("demo")

public class Demo {

	@Id
	@Column("id")
	private String id;
	@Column("name")
	private String name;
	@Version
	@Column("version")
	private Integer version;

	public Demo(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
