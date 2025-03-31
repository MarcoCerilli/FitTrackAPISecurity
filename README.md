**Applicazione REST per la gestione della palestra**

### **Descrizione**
Questa applicazione permette di gestire gli utenti iscritti a una palestra, i corsi disponibili e i pagamenti mensili. I dati sono persistiti in un database MySQL utilizzando JPA (Java Persistence API).

---

### **Tecnologie utilizzate**
- **Spring Boot 3.x**
- **Spring Security** (per la crittografia delle password con BCrypt)
- **Spring Data JPA**
- **MySQL** (come database relazionale)
- **Lombok** (per ridurre il boilerplate code)
- **Maven** (per la gestione delle dipendenze)

---

### **Entità principali**

#### **1. Utente**
Rappresenta un cliente iscritto alla palestra.

- **id** (Long) - Identificativo univoco
- **email** (String) - Deve essere univoca e non nulla
- **password** (String) - Viene criptata con BCrypt
- **active** (Boolean) - Indica se l'utente è attivo

#### **2. Corso**
Rappresenta un corso disponibile nella palestra.

- **id** (Long) - Identificativo univoco
- **nome** (String) - Nome del corso (es. "Pilates", "Crossfit")
- **descrizione** (String) - Descrizione del corso (opzionale)
- **postiDisponibili** (Integer) - Numero massimo di iscritti al corso

#### **3. Iscrizione**
Rappresenta l'iscrizione di un utente a un corso per un determinato mese.

- **id** (Long) - Identificativo univoco
- **utente** (ManyToOne con Utente) - L'utente iscritto
- **corso** (ManyToOne con Corso) - Il corso scelto
- **mese** (String) - Mese di riferimento dell'iscrizione (es. "Marzo 2025")
- **pagato** (Boolean) - Indica se la rata è stata pagata

---

### **Funzionalità e API REST**

#### **Utenti**
| Metodo | Endpoint | Descrizione |
|--------|-------------|-------------|
| `POST` | `/api/utenti` | Registra un nuovo utente (criptando la password) |
| `GET` | `/api/utenti` | Restituisce tutti gli utenti (solo email, active, id) |
| `GET` | `/api/utenti/{id}` | Restituisce un utente specifico (DTO) |
| `DELETE` | `/api/utenti/{id}` | Elimina un utente (opzionale) |

#### **Corsi**
| Metodo | Endpoint | Descrizione |
|--------|-------------|-------------|
| `POST` | `/api/corsi` | Aggiunge un nuovo corso |
| `GET` | `/api/corsi` | Restituisce tutti i corsi |
| `GET` | `/api/corsi/{id}` | Restituisce il dettaglio di un corso |

#### **Iscrizioni**
| Metodo | Endpoint | Descrizione |
|--------|-------------|-------------|
| `POST` | `/api/iscrizioni` | Registra un’iscrizione di un utente a un corso per un mese |
| `GET` | `/api/iscrizioni/utente/{id}` | Restituisce tutte le iscrizioni di un utente |
| `GET` | `/api/iscrizioni/corso/{id}` | Restituisce gli iscritti a un corso specifico |
| `PUT` | `/api/iscrizioni/{id}/paga` | Segna l'iscrizione come pagata |

---

### **Obiettivi didattici**
- Uso corretto di **JPA** e relazioni (`@ManyToOne`, `@JoinColumn`)
- Uso di **@RestController** e **@RequestMapping** per definire gli endpoint
- Creazione e uso dei **DTO** per evitare esposizione di dati sensibili
- Implementazione di **Spring Security** per la crittografia della password con BCrypt
- Uso di **Optional.map().orElse(...)** per una gestione sicura dei dati
- Test delle API con **Postman** o **Swagger**

---

### **Bonus (opzionali)**
- Validazione dei dati con **@Valid** e **@NotNull**
- Gestione degli errori con **@ExceptionHandler**
- Endpoint per filtrare utenti attivi o cercare corsi per nome

---

### **Configurazione database (application.properties)**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/palestra_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

### **Come eseguire l'applicazione**
1. **Configurare MySQL** e creare un database `palestra_db`
2. **Aggiornare `application.properties`** con le credenziali corrette
3. **Compilare ed eseguire l'applicazione**:
   ```sh
   mvn clean spring-boot:run
   ```
4. **Testare le API con Postman o Swagger**

---

Questa applicazione fornisce una solida base per la gestione di utenti, corsi e iscrizioni in una palestra, con un'architettura scalabile e sicura! 🚀

