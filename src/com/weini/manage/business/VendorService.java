package com.weini.manage.business;

import java.util.List;

import com.weini.manage.dao.VendorDao;
import com.weini.manage.entity.TVendor;

/**
 * Created by zsy on 15/4/13.
 */
public class VendorService extends GeneralService{
    private VendorDao vdao = new VendorDao(this.session);

    public List<TVendor> getVendorList(){
        List<TVendor> res = vdao.listVendor();
        this.close();
        return res;
    }

}
