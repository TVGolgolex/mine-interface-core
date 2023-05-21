package de.pascxl.minecraft.minecore.config.converter;

import de.pascxl.minecraft.minecore.config.InternalConverter;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashSet;

public class Set implements Converter {
    private final InternalConverter internalConverter;

    public Set( InternalConverter internalConverter ) {
        this.internalConverter = internalConverter;
    }

    @Override
    public Object toConfig( Class<?> type, Object obj, ParameterizedType genericType ) throws Exception {
        java.util.Set<Object> values = (java.util.Set<Object>) obj;
        java.util.List newList = new ArrayList();

        for (Object val : values) {
            Converter converter = internalConverter.getConverter(val.getClass());

            if (converter != null) {
                newList.add(converter.toConfig(val.getClass(), val, null));
            } else {
                newList.add(val);
            }
        }

        return newList;
    }

    @Override
    public Object fromConfig( Class type, Object section, ParameterizedType genericType ) throws Exception {
        java.util.List<Object> values = (java.util.List<Object>) section;
        java.util.Set<Object> newList = new HashSet<>();

        try {
            newList = (java.util.Set<Object>) type.newInstance();
        } catch ( Exception e ) {
        }

        if ( genericType != null && genericType.getActualTypeArguments()[0] instanceof Class ) {
            Converter converter = internalConverter.getConverter( (Class) genericType.getActualTypeArguments()[0] );

            if ( converter != null ) {
                for (Object value : values) {
                    newList.add(converter.fromConfig((Class) genericType.getActualTypeArguments()[0], value, null));
                }
            } else {
                newList.addAll( values );
            }
        } else {
            newList.addAll( values );
        }

        return newList;
    }

    @Override
    public boolean supports( Class<?> type ) {
        return java.util.Set.class.isAssignableFrom( type );
    }

}
