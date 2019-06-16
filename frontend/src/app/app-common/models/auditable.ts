import { Usuario } from './usuario';

export interface Auditable {
    createdBy: Usuario,
    createdDate: Date,
    lastModifiedBy: Usuario,
    lastModifiedDate: Date
}