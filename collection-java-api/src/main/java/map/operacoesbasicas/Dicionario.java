package map.operacoesbasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String > dicionarioMap;

    public Dicionario() {
        dicionarioMap = new HashMap<String, String>();
    }
    public void adicionarPalavra(String palavra, String definicao){
        dicionarioMap.put(palavra, definicao);
    }
    public void removerPalavra(String palavra){
        if(!dicionarioMap.isEmpty()){

            dicionarioMap.remove(palavra);
        }else{
            throw new RuntimeException("Está vazio.");
        }
    }
    public void exibirPalavra(){
        System.out.println(dicionarioMap);
    }
    public String pesquisarPorPalavra(String palavra){
        String definicao = dicionarioMap.get(palavra);
        if(definicao != null){
            return definicao;
        }
        return "Linguagem não encontrada.";
    }
}
