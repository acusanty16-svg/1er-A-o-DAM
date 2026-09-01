document.getElementById("year").textContent = new Date().getFullYear();

const layer = document.querySelector(".sparkle-layer");

if (layer) {
  let last = 0;

  window.addEventListener("pointermove", (e) => {
    const now = performance.now();

    if (now - last < 30) return;
    last = now;

    const s = document.createElement("div");
    s.className = "sparkle";
    s.textContent = "✨";
    layer.appendChild(s);

    gsap.set(s, {
      x: e.clientX,
      y: e.clientY,

      scale: 0.8,
      opacity: 1,
    });
    gsap.to(s, {
      y: e.clientY - 50 - Math.random() * 30,
      x: e.clientX + (Math.random() * 60 - 30),
      rotation: Math.random() * 180 - 90,
      scale: 0.2,
      opacity: 0,
      duration: 0.8,
      ease: "power2.out",
      onComplete: () => s.remove(),
    });
  });
}
