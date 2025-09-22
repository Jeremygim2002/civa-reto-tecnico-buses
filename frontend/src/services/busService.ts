import type { Bus, PageBusResponse } from '../types/bus';
import { API_BASE_URL, AUTH_CREDENTIALS, DEFAULT_PAGE, DEFAULT_PAGE_SIZE } from '../config/constants';

export class BusService {
  private static getHeaders(): HeadersInit {
    return {
      'Authorization': `Basic ${AUTH_CREDENTIALS}`,
      'Content-Type': 'application/json',
    };
  }

  /**
   * Obtiene la lista paginada de buses
   */
  static async getBuses(page: number = DEFAULT_PAGE, size: number = DEFAULT_PAGE_SIZE): Promise<PageBusResponse> {
    try {
      const response = await fetch(
        `${API_BASE_URL}/bus?page=${page}&size=${size}&sort=createdAt,desc`,
        {
          method: 'GET',
          headers: this.getHeaders(),
        }
      );

      if (!response.ok) {
        throw new Error(`Error ${response.status}: ${response.statusText}`);
      }

      return await response.json();
    } catch (error) {
      console.error('Error fetching buses:', error);
      throw error;
    }
  }

  /**
   * Obtiene un bus específico por ID
   */
  static async getBusById(id: number): Promise<Bus> {
    try {
      const response = await fetch(
        `${API_BASE_URL}/bus/${id}`,
        {
          method: 'GET',
          headers: this.getHeaders(),
        }
      );

      if (!response.ok) {
        throw new Error(`Error ${response.status}: ${response.statusText}`);
      }

      return await response.json();
    } catch (error) {
      console.error(`Error fetching bus ${id}:`, error);
      throw error;
    }
  }
}