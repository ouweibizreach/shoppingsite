package com.dao;

import com.bean.CategoryBean;
import com.bean.ItemBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    private Connection conn;

    public ItemDAO(){
       this.conn=GetConnection.getConn();
    }

    public List<CategoryBean> findAllCategory()
    {
        PreparedStatement psmt=null;
        ResultSet rs=null;
        List<CategoryBean>list=null;
        try
        {
            String sql="select * from category order by code";
            psmt=conn.prepareStatement(sql);
            rs=psmt.executeQuery();
            list=new ArrayList<CategoryBean>();
            while(rs.next())
            {
                int code=rs.getInt("code");
                String name=rs.getString("name");
                CategoryBean bean=new CategoryBean(code,name);
                list.add(bean);
            }
            return list;
        }catch(Exception e)
        {
            e.printStackTrace();


        }finally
        {
            try {
                if(rs!=null)rs.close();
                if(psmt!=null)psmt.close();



            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        return list;


    }

    public List<ItemBean> findByCategory(int categoryCode) throws DAOException
    {
        PreparedStatement psmt=null;
        ResultSet rs=null;
        List<ItemBean> list=null;

        try
        {
            String sql="select * from item where category_code=? order by code";
            psmt=conn.prepareStatement(sql);
            psmt.setInt(1,categoryCode);
            rs=psmt.executeQuery();
            list=new ArrayList<ItemBean>();
            while(rs.next())
            {
                int code=rs.getInt("code");
                String name=rs.getString("name");
                int price=rs.getInt("price");
                ItemBean ib=new ItemBean(code,name,price);
                list.add(ib);
            }

        } catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try{
                if(rs!=null) rs.close();
                if(psmt!=null) psmt.close();


            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        return list;

    }

    public ItemBean findByKey(int key )throws DAOException
    {
        PreparedStatement psmt=null;
        ResultSet rs=null;
        List<ItemBean> list=null;
        ItemBean ib=null;
        try
        {
            String sql="select * from item where code=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1,key);
            rs = psmt.executeQuery();
            if(rs.next())
            {
                int code=rs.getInt("code");
                String name=rs.getString("name");
                int price=rs.getInt("price");
                ib=new ItemBean(code,name,price);

            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try{
                if(rs!=null) rs.close();
                if(psmt!=null) psmt.close();


            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return ib;


    }







}
