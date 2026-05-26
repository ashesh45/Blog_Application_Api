const API = {
    BASE: 'http://localhost:8080/api',

    async request(url, options = {}) {
        const config = {
            headers: { 'Content-Type': 'application/json', ...options.headers },
            ...options
        };
        const res = await fetch(this.BASE + url, config);
        if (!res.ok) {
            const err = await res.json().catch(() => ({ message: res.statusText }));
            throw new Error(err.message || 'Request failed');
        }
        const text = await res.text();
        return text ? JSON.parse(text) : null;
    },

    /* ---- Users ---- */
    users: {
        getAll: () => API.request('/users/'),
        getById: (id) => API.request(`/users/${id}`),
        create: (data) => API.request('/users/', { method: 'POST', body: JSON.stringify(data) }),
        update: (id, data) => API.request(`/users/${id}`, { method: 'PUT', body: JSON.stringify(data) }),
        delete: (id) => API.request(`/users/${id}`, { method: 'DELETE' })
    },

    /* ---- Categories ---- */
    categories: {
        getAll: () => API.request('/categories/'),
        getById: (id) => API.request(`/categories/${id}`),
        create: (data) => API.request('/categories/', { method: 'POST', body: JSON.stringify(data) }),
        update: (id, data) => API.request(`/categories/${id}`, { method: 'PUT', body: JSON.stringify(data) }),
        delete: (id) => API.request(`/categories/${id}`, { method: 'DELETE' })
    },

    /* ---- Posts ---- */
    posts: {
        getAll: (page = 0, size = 10, sortBy = 'postId', sortDir = 'desc') =>
            API.request(`/posts?pageNumber=${page}&pageSize=${size}&sortBy=${sortBy}&sortDir=${sortDir}`),
        getById: (id) => API.request(`/posts/${id}`),
        getByUser: (userId) => API.request(`/user/${userId}/posts`),
        getByCategory: (catId) => API.request(`/category/${catId}/posts`),
        search: (keyword) => API.request(`/posts/search/${encodeURIComponent(keyword)}`),
        create: (userId, categoryId, data) =>
            API.request(`/user/${userId}/category/${categoryId}/posts`, { method: 'POST', body: JSON.stringify(data) }),
        update: (id, data) => API.request(`/posts/${id}`, { method: 'PUT', body: JSON.stringify(data) }),
        delete: (id) => API.request(`/posts/${id}`, { method: 'DELETE' })
    }
};
