import z from './zod';

export const LoginSchema = z.object({
  email: z.email(),
  password: z.string().min(1),
});

export type LoginForm = z.infer<typeof LoginSchema>;
