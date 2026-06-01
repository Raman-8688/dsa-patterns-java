# Three Sum Problem – DSA Notes

## ❓ Question
Given an integer array `nums`, find all unique triplets `(a, b, c)` such that:


Example:  
Input: `[-1, 0, 1, 2, -1, -4]`  
Output: `[[-1, -1, 2], [-1, 0, 1]]`

---

## 🪓 Brute Force Approach
- Iterate over all possible triplets `(i, j, k)`.
- Check if `nums[i] + nums[j] + nums[k] == 0`.
- Store triplets in a set to avoid duplicates.
- **Time Complexity:** O(n³)
- **Space Complexity:** O(n) (for storing results)

---

## ⚡ Optimized Algorithm (Two Pointers)
👉 Golden mantra: **“Fix one, hunt two.”**

1. **Sort the array** → ensures duplicates are adjacent and simplifies pointer movement.
2. **Fix one element (`i`)** → loop through array, treating each element as the first number of the triplet.
3. **Skip duplicates** → if current fixed element equals the previous one, continue.
4. **Two pointers search**:
    - Set `left = i + 1`, `right = n - 1`.
    - Compute `sum = nums[i] + nums[left] + nums[right]`.
    - If `sum == 0` → record triplet, then skip duplicates for both pointers.
    - If `sum < 0` → move `left++` (need bigger sum).
    - If `sum > 0` → move `right--` (need smaller sum).
5. **Collect results** → add valid triplets to the result list.

**Time Complexity:** O(n²)  
**Space Complexity:** O(1) (ignoring result storage)

---

## 🌟 Golden Technique (Memory Trick)
👉 Visualize it like this:
- **“One anchor, two divers.”**
    - Anchor = fixed element (`i`).
    - Two divers (`left`, `right`) swim inward to meet at the target sum.

Shortcut phrase:  
**“Sort → Fix → Two Pointers → Skip Duplicates.”**

---

## 📘 What You Should Learn
- **[Sorting](ca://s?q=Sorting_array_for_three_sum)** helps simplify duplicate handling.
- **[Two pointers](ca://s?q=Two_pointers_in_three_sum)** is the key pattern for sum problems.
- **[Duplicate skipping](ca://s?q=Skipping_duplicates_in_three_sum)** ensures uniqueness.
- **[Problem reduction](ca://s?q=Reducing_three_sum_to_two_sum)**: 3‑Sum reduces to 2‑Sum once you fix one element.
- This is a **template problem** → mastering it unlocks 4‑Sum, k‑Sum, and other variations.

---

## ✅ Key Takeaway
- Brute force is too slow (O(n³)).
- Optimized two pointers after sorting gives O(n²).
- Always remember: **“Fix one, hunt two.”**
