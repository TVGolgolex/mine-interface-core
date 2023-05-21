package de.pascxl.minecraft.minecore.database.mongodb;

/**
 * Created by Pascal K. on 11.02.2023.
 */
public interface IRepository< TDocument, TIdentifier > {

    void insertValue( TDocument value );

    TDocument get( TIdentifier identifier );

    TDocument getOrCreate( TIdentifier identifier, Object... objects );

    TDocument update( TIdentifier identifier, TDocument value );

}
