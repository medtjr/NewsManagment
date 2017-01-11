package com.pfe.ahmed.facade.converters;


import com.google.common.base.Preconditions;

public abstract class AbstractConverter<SOURCE, TARGET> implements
		Converter<SOURCE, TARGET> {

	public void validateParameterNotNull(Object parameter, String nullMessage) {
		Preconditions.checkArgument(parameter != null, nullMessage);
	}
}
