export interface ValidationConstraints {
    timestamp: Date,
    status: number,
    error: string,
    errors: ValidationError[],
    message: string,
    path: string
}

export interface ValidationError {
    codes: string[],
    arguments: ErrorArgument[],
    defaultMessage: string,
    objectName: string,
    field: string,
    rejectedValue: string,
    bindingFailure: boolean,
    code: string
}

export interface ErrorArgument {
    codes: string[],
    arguments: ErrorArgument[],
    defaultMessage: string,
    code: string
}
