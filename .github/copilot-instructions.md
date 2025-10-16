# Instruções para Agentes de IA - API Chamados RHMED

## Arquitetura do Projeto

Este é um projeto Spring Boot 3.5.x que segue uma arquitetura limpa (Clean Architecture) com as seguintes camadas:

- `core/` - Contém o domínio da aplicação (entidades, exceções, enums)
- `usecase/` - Define as interfaces dos casos de uso
- `application/` - Implementa os casos de uso definidos em `usecase/`
- `infrastructure/` - Camada externa com controladores, repositórios, DTOs e configurações

### Principais Padrões e Convenções

1. **Injeção de Dependências**: Use construtores para injeção (não use @Autowired)
```java
public class TicketController {
    private final CreateTicketUseCase createTicketUseCase;
    
    public TicketController(CreateTicketUseCase createTicketUseCase) {
        this.createTicketUseCase = createTicketUseCase;
    }
}
```

2. **Casos de Uso**: Defina interfaces na pasta `usecase/` e implemente em `application/usecaseimpl/`
   - Interface: `usecase/src/main/java/com/example/CreateTicketUseCase.java`
   - Implementação: `application/src/main/java/com/example/usecaseimpl/CreateTicketUseCaseImpl.java`

3. **DTOs**: Use classes Request/Response em `infrastructure/src/main/java/com/example/dto/`
   - Requests: `infrastructure/src/main/java/com/example/dto/request/`
   - Responses: `infrastructure/src/main/java/com/example/dto/response/`

4. **Mapeamento**: Use classes mapper para converter entre DTOs e entidades de domínio
   - Exemplo: `infrastructure/src/main/java/com/example/mapper/TicketMapper.java`

## Fluxos Principais

1. **Tickets**:
   - Criação → Análise → Validação → Conclusão
   - Status são gerenciados através do `ChangeTicketStatusUseCase`
   - Controllers em `infrastructure/src/main/java/com/example/controller/TicketController.java`

2. **Usuários**:
   - Sistema usa autenticação Spring Security
   - `@AuthenticationPrincipal` para acessar usuário autenticado nos controllers

## Configuração e Execução

1. **Requisitos**:
   - Java 17+
   - Maven 3.x

2. **Build**:
```powershell
mvn clean install
```

3. **Execução**:
```powershell
mvn spring-boot:run -pl infrastructure
```

## Boas Práticas

1. Mantenha a separação de camadas respeitando a Clean Architecture
2. Use DTOs para comunicação entre camadas de infraestrutura e aplicação
3. Implemente validações no nível de domínio usando exceções customizadas
4. Use enums para valores fixos (exemplo: status de tickets)
5. Documente endpoints usando OpenAPI/Swagger quando necessário

## Arquivos Chave

- `pom.xml` - Configuração do projeto e dependências
- `infrastructure/src/main/resources/application.properties` - Configurações da aplicação
- `core/src/main/java/com/example/domain/` - Entidades e regras de domínio
- `infrastructure/src/main/java/com/example/TicketRhmedApplication.java` - Ponto de entrada da aplicação