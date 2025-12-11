# AuthForge 🔐
A full-stack **Authentication & Authorization** system built with **Spring Boot + React**.  
Currently **in active development** 🚧 - features are being improved and expanded.

---

## 🚀 About the Project
AuthForge is a secure and scalable authentication system that implements **JWT Authentication**, **OTP Email Verification**, **Password Reset**, and **Role-Based Access Control**.  
The frontend uses **React** with protected routes, while the backend uses **Spring Security** for robust access management.

---

## 🧩 Key Features
- ✔️ JWT-based Authentication & Authorization  
- ✔️ Login + Registration (React + Spring Boot)  
- ✔️ OTP Email Verification (JavaMailSender)  
- ✔️ Password Reset via Email  
- ✔️ Protected Routes in React  
- ✔️ Role-Based Access (Admin & User)  
- ✔️ API Integration (POST, GET requests)  
- ✔️ Clean UI using Bootstrap 5  
- ✔️ MySQL Database Integration  
- ✔️ Full-Stack Setup (Backend + Frontend)

---

## 🧑‍💻 Tech Stack

### **Backend**
- Spring Boot  
- Spring Security  
- JavaMail  
- JWT  
- MySQL  

### **Frontend**
- ReactJS  
- Bootstrap 5  
- Axios  

---

## 📌 API Endpoints

### **Authentication**
| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | `/register` | Register a new user |
| POST | `/verify-otp` | Verify OTP sent via email |
| POST | `/login` | Login & receive JWT |
| POST | `/reset-password` | Request password reset |
| POST | `/update-password` | Update password |

---

## 📁 Project Structure
```
AuthForge/
│
├── backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/      
│   │       └── resources/  
│   ├── target/
│   └── pom.xml
│
└── frontend/
    ├── src/               
    ├── public/            
    └── package.json
```


---

## 🔧 Setup Instructions

### **Backend**
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### **Frontend**
```bash
cd frontend
npm install
npm start
```


## Current Status
Active development ongoing
More features and improvements are being added regularly.

## Contributing
Contributions are welcome - feel free to open issues or submit pull requests.
