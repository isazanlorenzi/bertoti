import java.util.List;
import java.util.LinkedList;

public class SalaAula {
    
    private List<Aluno> alunos = new LinkedList<>();

    public SalaAula() {
        // Construtor padrão
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    
    public List<Aluno> getAlunos() {
        return alunos;
    }
}
