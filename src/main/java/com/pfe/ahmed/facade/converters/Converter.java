package com.pfe.ahmed.facade.converters;


public interface Converter<SOURCE, TARGET> extends org.springframework.core.convert.converter.Converter<SOURCE, TARGET> {
	@Override
	public abstract TARGET convert(SOURCE source);

	public abstract TARGET convert(SOURCE source, TARGET target);

}
