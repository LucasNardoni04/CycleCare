package br.com.umc.cyclecare.controller.records.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequestRecord (@NotBlank(message = "O nome é obrigatório.")
                                     String nome,

                                     @NotBlank(message = "O e-mail é obrigatório.")
                                     @Email(message = "E-mail inválido.")
                                     String email,

                                     @NotBlank(message = "A senha é obrigatória.")
                                     @Size(min = 8, message = "A senha deve ter pelo menos 8 dígitos.")
                                     @Pattern(
                                             regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
                                             message = "A senha deve conter letra maiúscula, minúscula, número e caractere especial"
                                     )
                                     String senha,

                                     @NotBlank
                                     @Size(min = 11, max = 11, message = "O Telefone deve conter 11 dígitos.")
                                     String telefone) {}
