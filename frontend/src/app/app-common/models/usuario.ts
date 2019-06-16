import { Auditable } from './auditable';

export interface Usuario extends Auditable {
    id: number,
    nome: string;
    senha: string;
}
