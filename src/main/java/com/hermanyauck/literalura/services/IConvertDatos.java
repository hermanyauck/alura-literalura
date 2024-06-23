package com.hermanyauck.literalura.services;

public interface IConvertDatos {

    <T> T obtenerDatos(String json, Class<T> clase);

}
