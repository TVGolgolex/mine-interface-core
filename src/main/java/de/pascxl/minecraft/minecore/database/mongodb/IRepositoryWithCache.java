package de.pascxl.minecraft.minecore.database.mongodb;

/**
 * Created by Pascal K. on 11.02.2023.
 */
public interface IRepositoryWithCache< TDocument, TIdentifier > extends IRepository< TDocument, TIdentifier > {

    TDocument getAndCache( TIdentifier identifier );

    void register( TDocument value );

    void unRegister( TIdentifier identifier );

}
