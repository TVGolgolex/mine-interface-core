package de.pascxl.minecraft.minecore.config.converter;

import de.pascxl.minecraft.minecore.config.ConfigSection;
import de.pascxl.minecraft.minecore.config.InternalConverter;
import de.pascxl.minecraft.minecore.config.YamlConfig;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

public class Config implements Converter {
    private final InternalConverter internalConverter;

    public Config( InternalConverter internalConverter ) {
        this.internalConverter = internalConverter;
    }

    @Override
    public Object toConfig( Class<?> type, Object obj, ParameterizedType parameterizedType ) throws Exception {
        return ( obj instanceof Map ) ? obj : ( (YamlConfig) obj ).saveToMap( obj.getClass() );
    }

    @Override
    public Object fromConfig( Class type, Object section, ParameterizedType genericType ) throws Exception {
        YamlConfig obj = (YamlConfig) newInstance( type );

        // Inject Converter stack into subconfig
        for ( Class aClass : internalConverter.getCustomConverters() ) {
            obj.addConverter( aClass );
        }

        obj.loadFromMap( ( section instanceof Map ) ? (Map) section : ( (ConfigSection) section ).getRawMap(), type );
        return obj;
    }

    // recursively handles enclosed classes
    public Object newInstance( Class type ) throws Exception {
        Class enclosingClass = type.getEnclosingClass();
        if ( enclosingClass != null ) {
            Object instanceOfEnclosingClass = newInstance( enclosingClass );
            return type.getConstructor( enclosingClass ).newInstance( instanceOfEnclosingClass );
        } else {
            return type.newInstance();
        }
    }

    @Override
    public boolean supports( Class<?> type ) {
        return YamlConfig.class.isAssignableFrom( type );
    }
}
