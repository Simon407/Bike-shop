package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.entity.Category;
import com.springapp.mvc.entity.Goods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class GoodRepositoryHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addGood(Goods goodInfo) {
        curSession().save(goodInfo);
    }

    public void updateGood(Goods goodInfo) {
        curSession().saveOrUpdate(goodInfo);
    }

    public void deleteGood(Long goodId) {
        curSession().delete(new Goods(goodId));
    }

    public Goods getGoodById(Long goodId) {
        return (Goods) curSession().get(Goods.class, goodId);
    }

    public List<Goods> getGoodsByTypeId(Long typeId) {
        List<Goods> goods = new ArrayList<Goods>();
        try {
            goods = (List<Goods>) curSession().createQuery("select new list(g.id, g.name,g.modelNo, g.price, g.picLink, g.typeId, g.brandId, g.description) from Goods g " +
                    "where g.typeId = :typeId")
                    .setLong("typeId", typeId)
                    .list();
        } catch (Exception e) {
            System.err.println("Error in getAllGoods(): " + e.getMessage());
        }
        return goods;
    }

    // FIXME: вынести в сервис
    public List<Goods> getGoodsByMainId(Long mainId) {
        Category c = (Category) curSession().get(Category.class, mainId);
        List<Long> list = new ArrayList<Long>();
        for (Category ca : c.getChildren()) {
            if (!list.contains(ca.getId())) {
                list.add(ca.getId());
            }
        }
        List<Goods> goods = null;
        for (Long l : list) {
            List<Goods> listGoods = (List<Goods>) curSession().createCriteria(Goods.class).add(Restrictions.eq("type_id", l.toString())).list();
            if (!listGoods.isEmpty()) goods.addAll(listGoods);
        }
        return goods;
    }

    public List<Goods> getAllGoods() {
        return curSession().createCriteria(Goods.class).list();
    }
}
