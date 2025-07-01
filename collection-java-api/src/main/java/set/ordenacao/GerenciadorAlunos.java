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
            if (alunoParaRemover != null) {
                alunosSet.remove(alunoParaRemover);
            } else {
                System.out.println("Matrícula não encontrada.");
            }
        } else {
            throw new RuntimeException("Seu conjunto está vazio!");
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
    public static void main(String[] args) {

        // Criando o gerenciador
        GerenciadorAlunos gerenciador = new GerenciadorAlunos();

        // Adicionando alunos
        gerenciador.adicionarAluno("Lucas", 123L, 7.5);
        gerenciador.adicionarAluno("Amanda", 456L, 9.0);
        gerenciador.adicionarAluno("Bruno", 789L, 6.8);
        gerenciador.adicionarAluno("Carlos", 321L, 8.2);

        System.out.println("\n🟢 Todos os alunos (ordenados por nome):");
        gerenciador.exibirAlunos();  // TreeSet já ordena por nome

        // Exibindo alunos por nome (cria um novo TreeSet, mas no caso já tá ordenado)
        System.out.println("\n🟢 Exibindo por nome novamente:");
        System.out.println(gerenciador.exibirAlunosPorNome());

        // Exibindo alunos por nota (usando Comparator personalizado)
        System.out.println("\n🟢 Exibindo alunos por nota:");
        System.out.println(gerenciador.exibirAlunosPorNota());

        // Removendo um aluno por matrícula
        System.out.println("\n🔴 Removendo aluno de matrícula 456:");
        gerenciador.removerAlunoPorMatricula(456L);

        System.out.println("\n🟢 Lista atualizada após remoção:");
        gerenciador.exibirAlunos();

        // Tentando remover aluno que não existe
        System.out.println("\n🔴 Tentando remover matrícula inexistente:");
        gerenciador.removerAlunoPorMatricula(999L);

    }
}
