# UFC Event Matchmaking, Stat Aggregation & Fighter Management Service

A production-grade, RESTful backend service built with **Spring Boot 3**, **Spring Data JPA**, and **PostgreSQL**. The system models the real-world operational domain of the UFC: tracking fighter career statistics, managing event fight cards, evaluating head-to-head match-ups, and processing transactional bout outcomes with guaranteed ACID consistency.

---

## 🛠️ Tech Stack & Engineering Architecture

* **Framework:** Spring Boot 3.x
* **Language:** Java 17+
* **Persistence & ORM:** Spring Data JPA / Hibernate
* **Database & Migrations:** PostgreSQL & Flyway (Versioned raw SQL migrations: `V1__...sql`, `V2__...sql`)
* **Data Transfer & Security:** Java `records` (DTO pattern), `@JsonProperty`, Jackson
* **Validation & Exception Handling:** Bean Validation (`@Valid`, `@NotNull`, `@Min`), Custom Exception Handler (`@ControllerAdvice`)
* **Transaction Management:** Spring `@Transactional`
* **Version Control:** Git / GitHub (`https://github.com/Embbrz/ufc-explorer`)

---

## 🚀 Key Features & Domain Implementation

### 1. Fighter Management & Analytics
* **Registration & Bio-Data Validation:** Register new fighters with validated physical attributes (stance, reach, weight class) and initial baseline stats.
* **Dynamic Search & Leaderboard Engine:** Advanced URL-driven filtering, multi-field sorting, and limit/offset pagination with zero memory bloat using Spring Data `Pageable` and `Sort`.
* **Partial Stat Updates:** Atomic payload updates via Java records to modify post-fight career metrics without wiping existing entity state.
* **Head-to-Head Analytics:** Specialized comparison endpoint evaluating two fighters head-to-head (`?fighterA=X&fighterB=Y`), dynamically calculating physical metrics, reach advantages, and statistical match-up breakdowns via custom DTO responses.

### 2. Events & Fight Card Management
* **Event Creation:** Build event cards with locations, dates, and venues.
* **Fight Card Retrieval:** Fetch full fight cards organized by event ID.
* **Nested Bout Scheduling & Guard Rules:** Add or remove bouts on an event card using clean RESTful nested endpoints. Enforces domain business rules: validates weight-class parity between fighters (or flags catchweight) and prevents double-booking a fighter on the same event card.

### 3. Transactional Bout Result Engine
* **Automated Record Processing:** Records official fight outcomes (Winner ID, Method: KO/Submission/Decision, Round, Time).
* **Atomic ACID Updates:** Uses `@Transactional` to guarantee that updating the bout outcome and incrementing the winner's win count and loser's loss count occur concurrently in a single atomic database unit of work, automatically rolling back if any step fails.

---

## 📡 API Endpoints Summary

### 🥊 Fighters
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/v1/fighters` | Register a new fighter with validated bio-data |
| `GET` | `/api/v1/fighters/search` | Dynamic search, filtering (`weightClass`, `minWins`), and pagination |
| `PUT` | `/api/v1/fighters/{id}/stats` | Partial update of fighter career statistics |
| `GET` | `/api/v1/fighters/head-to-head` | Head-to-head comparison tool between two fighters |

### 📅 Events & Bouts
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/v1/events` | Create a new UFC event card |
| `GET` | `/api/v1/events` | Fetch all scheduled events (paginated) |
| `GET` | `/api/v1/events/{id}/card` | Fetch the full fight card for an event |
| `POST` | `/api/v1/events/{eventId}/bouts` | Schedule a bout onto an event (enforces weight class rules) |
| `DELETE` | `/api/v1/events/{id}/bouts/{boutId}` | Remove a scheduled bout from an event card |

### 🏆 Match Results
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/v1/bouts/{boutId}/result` | Record fight outcome & atomically update winner/loser records |

---

## 🏁 Getting Started

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/Embbrz/ufc-explorer.git](https://github.com/Embbrz/ufc-explorer.git)
   cd ufc-explorer