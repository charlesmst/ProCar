/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.ordem;

import model.estoque.EstoqueMovimentacao;
import model.fluxo.Conta;
import model.fluxo.Parcela;
import model.ordem.Ordem;
import model.ordem.OrdemServico;
import services.Service;
import services.ServiceException;

/**
 *
 * @author charles
 */
public class OrdemService extends Service<Ordem> {

    @Override
    public void update(Ordem obj) throws ServiceException {
        insert(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Ordem obj) throws ServiceException {
        executeOnTransaction((s,t)->{
            s.saveOrUpdate(obj);
            t.commit();
        });
        
    }

    public OrdemService() {
        super(Ordem.class);
    }

    public Ordem findOrdem(int id) {
        return (Ordem) selectOnSession((s) -> {
            Ordem c = (Ordem) s.createQuery(" select p"
                    + " from Ordem p  "
                    + " left outer join fetch p.ordemServicos e "
                    + " left outer join fetch p.estoqueMovimentacaos s "
                    //                    + " left outer join fetch e.pagamentos"
                    + " where p.id = :p"
            )
                    .setInteger("p", id)
                    .uniqueResult();
            return c;
        });
    }
    public double valorTotal(Ordem obj){
        double v = 0;
        for (EstoqueMovimentacao estoqueMovimentacao : obj.getEstoqueMovimentacaos()) {
            v+= 0;//@Todo Pegar valor de estoque;
        }
        for (OrdemServico ordemServico : obj.getOrdemServicos()) {
            v+= ordemServico.getValorEntrada();
        }
        return v;
    }
}
