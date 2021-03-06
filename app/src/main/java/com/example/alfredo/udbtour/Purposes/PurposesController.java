package com.example.alfredo.udbtour.Purposes;

import com.example.alfredo.udbtour.utils.Core;

import java.util.List;

/**
 * Created by Ariel on 03/03/2018.
 */

public class PurposesController implements PurposesOperations {

    DaoSession daoSession; ///Objeto de la sesion
    PurposesDao purposesDao;  //notasDao sera quien maneje las operaciones de la tabla


    public PurposesController(){
      ///  Core.getInstance().DeleteAllBases(); //ESTO BORRA TODOS LOS DATOS DE LA BASE, QUITAR!!!!!!!
        daoSession = Core.getInstance().getDaoSession(); //Se recupera la sesion del singleton
        purposesDao = daoSession.getPurposesDao(); //se recupera el manejador de la sesion
        /*Aquí inserto una lista de datos en la base de datos*/


    }


    @Override
    public boolean save(Purposes purposes) {
        try{
            purposesDao.save(purposes);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean update(Purposes purposes) {
        try{
            purposesDao.update(purposes);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean delete(Purposes purposes) {
        try{
            purposesDao.delete(purposes);
            return true;
        }
        catch(Exception e)
        {
             return false;
        }
    }

    @Override
    public List<Purposes> getAll() {
        //return purposesDao.queryBuilder().orderAsc(PurposesDao.Properties.Percentage).list();
        return purposesDao.loadAll();
    }

    @Override
    public Purposes get(Long ID) {
        return purposesDao.load(ID);
    }


}
