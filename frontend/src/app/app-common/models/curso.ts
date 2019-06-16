import { Auditable } from './auditable';
import { Aluno } from './aluno';

export interface Curso extends Auditable {
    id: number,
    nome: string,
    temAlunosMatriculados: boolean,
    alunos: Aluno[]
}
