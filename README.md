# ☕ Caffeine App  
### Coffee Ordering with Jetpack Compose & Fluid Animations  

Caffeine is a modern Android coffee-ordering UI application built entirely with **Kotlin** and **Jetpack Compose**.  
It demonstrates the expressive power of **Compose Animations** in creating smooth, delightful, and interactive user experiences.  

---
🎥 Demo Video

📽️ Watch the full app animation demo here:


https://github.com/user-attachments/assets/010d017f-3b89-4e1d-bc83-5818bd96ff56


💡 Inspiration

Built to explore how Jetpack Compose and its animation system can bring life to even the simplest app flows.
Caffeine is more than just coffee — it’s about crafting experiences that move. ☕💫

## 🌟 Key Features  

- **Expressive Animations:**  
  Beautiful screen transitions and component-level animations built using Jetpack Compose’s animation APIs.  

- **Interactive UX:**  
  Event-driven interactions like the “Bring my coffee” button trigger delightful motion sequences.  

- **Smooth Product Selection:**  
  Animated carousels for choosing coffee type, size (S, M, L), and caffeine intensity (Low, Medium, High).  

- **Progressive Order Experience:**  
  A clean “Almost Done” screen visualizing coffee preparation with looping animations.  

---

## ✨ Animation Highlights  

### 1. Initial Screen Transition  
The splash and home elements (text, cup image, and button) appear using `AnimatedVisibility` and `enter/exit` transitions,  
creating a welcoming animated introduction.  

**Example:**  
When tapping *“Bring my coffee”*, the next screen slides in using `slideInHorizontally()` and fades smoothly with `FadeIn`.  

---

### 2. Coffee Selection Transitions  
The coffee carousel uses **scaling and alpha** animations to highlight the active cup.  
Selection states for size and caffeine levels are animated with:  
- `animateColorAsState()` → smooth color transitions.  
- `animateDpAsState()` → gentle resizing for visual feedback.  

---

### 3. “Almost Done” Preparation Screen  
A fun, looping animation using `rememberInfiniteTransition()` simulates coffee drops or waves —  
a simple way to turn waiting into a pleasant moment.  

---

### 4. Take Away Toggle Animation  
A custom animated switch between ON/OFF states built with `updateTransition()` and `Animatable`.  
This replaces the default toggle behavior with a lively and tactile motion effect.  

---

## 🛠️ Tech Stack  

| Technology | Purpose |
|-------------|----------|
| **Kotlin** | Primary programming language |
| **Jetpack Compose** | Declarative UI framework |
| **Compose Navigation** | Screen transitions management |
| **Compose Animation APIs** | Motion and state-driven visuals |
| `AnimatedVisibility` | Appear/disappear effects |
| `animate*AsState` | Animate color, size, position |
| `updateTransition` | Multi-state animations |
| `graphicsLayer` | Rotation, scale, and alpha effects |

---

## Getting Started  

### 1. Clone the repository  
```bash
git clone https://github.com/Radwa85/caffeine.git
