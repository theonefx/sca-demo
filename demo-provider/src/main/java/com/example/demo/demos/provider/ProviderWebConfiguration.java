package com.example.demo.demos.provider;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Configuration
public class ProviderWebConfiguration {
	@Bean
	public HttpMessageConverters messageConverters() {
		//json
		FastJsonHttpMessageConverter jsonMessageConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setCharset(StandardCharsets.UTF_8);
		jsonMessageConverter.setFastJsonConfig(fastJsonConfig);
		List<MediaType> jsonMediaTypes = new ArrayList<>();
		jsonMediaTypes.add(MediaType.APPLICATION_JSON);
		jsonMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		jsonMessageConverter.setSupportedMediaTypes(jsonMediaTypes);

		//xml
		MappingJackson2XmlHttpMessageConverter xmlMessageConverter = new MappingJackson2XmlHttpMessageConverter();
		xmlMessageConverter.setObjectMapper(new XmlMapper());
		xmlMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);
		List<MediaType> xmlMediaTypes = new ArrayList<>();
		xmlMediaTypes.add(MediaType.APPLICATION_XML);
		xmlMediaTypes.add(MediaType.TEXT_XML);
		xmlMessageConverter.setSupportedMediaTypes(xmlMediaTypes);

		return new HttpMessageConverters(Arrays.asList(jsonMessageConverter, xmlMessageConverter));
	}
}
