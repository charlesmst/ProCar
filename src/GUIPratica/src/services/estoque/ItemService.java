/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.estoque;

import java.util.List;
import model.estoque.Estoque;
import model.estoque.Item;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.spi.ServiceException;
import services.Service;

public class ItemService extends Service<Item> {

    @Override
    public void update(Item obj) throws services.ServiceException {
        obj.setDescricao(obj.getDescricao().toUpperCase());
        super.update(obj);
    }

    @Override
    public void insert(Item obj) throws services.ServiceException {
        obj.setDescricao(obj.getDescricao().toUpperCase());
        super.insert(obj);
    }

    public boolean unico(int id, String descricao) throws ServiceException {
        return findFilter(Restrictions.ne("id", id), Restrictions.eq("descricao", descricao)).isEmpty();
    }

    public ItemService() {
        super(Item.class);
    }

    public int verificaQuantidadeDisp(Item i) {
        List<Estoque> estoqueDoItem = new EstoqueService().findBy("item.id", i.getId());
        int quantidade = 0;
        for (Estoque e : estoqueDoItem) {
            quantidade = quantidade + e.getQuantidadeDisponivel();
        }
        return quantidade;
    }
}
