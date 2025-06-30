package set.ordenacao;

import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new TreeSet<Aluno>();
    }
    public void adicionarAluno(String nome, Long matricula, double media){
        alunosSet.add(new Aluno(nome, matricula, media));
    }
    public void removerAlunoPorMatricula(long matricula){
        Aluno alunoParaRemover = null;
        if(!alunosSet.isEmpty()){
        for (Aluno a : alunosSet) {
            if (a.getMatricula() == matricula) {
                alunoParaRemover = a;
                break;
            }
        }
        alunosSet.remove(alunoParaRemover);
        }else {
            throw new RuntimeException("Seu conjunto esta vazio!");
        }
        if (alunoParaRemover == null){
            System.out.println("Matricula não encontrada");
        }
    }
    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> exibirPorNome = new TreeSet<>(alunosSet);
        return exibirPorNome;
    }
    public Set<Aluno> exibirAlunosPorNota(){
        Set<Aluno> exibirPorNota = new TreeSet<>(new ExibirNota());
        exibirPorNota.addAll(alunosSet);
        return exibirPorNota;
    }
    public void exibirAlunos(){
        System.out.println(alunosSet);
    }
}
