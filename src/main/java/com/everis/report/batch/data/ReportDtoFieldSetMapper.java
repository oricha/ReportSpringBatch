package com.everis.report.batch.data;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

@Component("fieldSetMapper")
public class ReportDtoFieldSetMapper implements FieldSetMapper<ReportDto> {

	@Override
	public ReportDto mapFieldSet(FieldSet fieldSet) throws BindException {

		return new ReportDto(fieldSet.readString("modulo"),
				fieldSet.readString("entorno"), fieldSet.readString("batch"),
				fieldSet.readString("fecha"), fieldSet.readString("min"),
				fieldSet.readString("seg"), fieldSet.readString("script"),
				fieldSet.readString("fecha2"), fieldSet.readString("min2"),
				fieldSet.readString("seg2"), fieldSet.readString("rC"),fieldSet.readString("rC2"),
				fieldSet.readString("estado"), fieldSet.readString("tiempo"),
				fieldSet.readString("observaciones"),
				fieldSet.readString("cadena"));
	}

	public ReportDtoFieldSetMapper() {

	}

}
