import { Auditable } from './auditable';
import { Curso } from './curso';

export interface Aluno extends Auditable {
    id: number,
    nome: string,
    email: string,
    cursos: Curso[]
}
